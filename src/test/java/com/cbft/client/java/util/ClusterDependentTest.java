package com.cbft.client.java.util;


import java.io.File;

import com.couchbase.client.deps.io.netty.util.ResourceLeakDetector;
import com.couchbase.client.java.bucket.BucketManager;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.repository.Repository;
import com.couchbase.client.java.util.features.CouchbaseFeature;
import com.couchbase.client.java.util.features.Version;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.bucket.BucketType;
import com.couchbase.client.java.cluster.ClusterManager;
import com.couchbase.client.java.cluster.DefaultBucketSettings;
/**
 * Base test class for tests that need a working cluster reference.
 *
 * @author Michael Nitschinger
 * @author Simon Baslé
 */
public class ClusterDependentTest {

    static {
        ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.PARANOID);
    }

    private static final String seedNode = TestProperties.seedNode();
    private static final String adminName = TestProperties.adminName();
    private static final String adminPassword = TestProperties.adminPassword();

    private static CouchbaseEnvironment env;
    private static Cluster cluster;
    private static Bucket bucket;
    private static ClusterManager clusterManager;
    private static BucketManager bucketManager;
    private static Repository repository;

    @BeforeClass
    public static void connect() throws Exception {
        env = DefaultCouchbaseEnvironment
            .builder()
            .queryEnabled(queryEnabled())
            .build();
        cluster = CouchbaseCluster.create(env, seedNode);
        clusterManager = cluster.clusterManager(adminName, adminPassword);
        boolean exists = clusterManager.hasBucket(bucketName());

        if (!exists) {
            clusterManager.insertBucket(DefaultBucketSettings
                .builder()
                .name(bucketName())
                .quota(256)
                .password(password())
                .enableFlush(true)
                .type(BucketType.COUCHBASE)
                .build());
        }

        bucket = cluster.openBucket(bucketName(), password());
        repository = bucket.repository();
        bucketManager = bucket.bucketManager();
        bucketManager.flush();
        
        //remove it after cbft integrate it with watson
//        ProcessBuilder builder = new ProcessBuilder("sh", "-c", cbftPath);
//        builder.redirectOutput(new File(cbftOutput));
//        builder.redirectError(new File("cbftTestError.txt"));
//        Process p = builder.inheritIO().start();
//
//        if (p.waitFor() == 0){
//            System.out.println("cbft daemon created");
//            //wait 2 seconds for cbft to full boot
//            Thread.sleep(2000);
//        }else{
//            System.err.println("cbft fail to start");
//        }
    }

    @AfterClass
    public static void disconnect() throws InterruptedException {
        cluster.disconnect();
    }

    /**
     * By calling this in @BeforeClass with a {@link CouchbaseFeature},
     * tests will be skipped is said feature is not available on the cluster.
     *
     * @param feature the feature to check for.
     */
    public static void ignoreIfMissing(CouchbaseFeature feature) {
        Assume.assumeTrue(clusterManager().info().checkAvailable(feature));
    }

    /**
     * By calling this in @BeforeClass with a {@link Version},
     * tests will be skipped is all nodes in the cluster are not above
     * or at that version.
     *
     * @param minimumVersion the required version to check for.
     */
    public static void ignoreIfClusterUnder(Version minimumVersion) {
        Assume.assumeTrue(clusterManager().info().getMinVersion().compareTo(minimumVersion) >= 0);
    }

    public static String password() {
        return  TestProperties.password();
    }

    public static CouchbaseEnvironment env() {
        return env;
    }

    public static Cluster cluster() {
        return cluster;
    }

    public static Bucket bucket() {
        return bucket;
    }

    public static String bucketName() {
        return TestProperties.bucket();
    }

    public static boolean queryEnabled() {
        return TestProperties.queryEnabled();
    }

    public static Repository repository() {
        return repository;
    }

    public static ClusterManager clusterManager() {
        return clusterManager;
    }

    public static BucketManager bucketManager() {
        return bucketManager;
    }
}
