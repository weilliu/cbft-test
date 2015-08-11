package com.cbft.client.java.util;


public class TestProperties {

    private static String seedNode;
    private static String bucket;
    private static String password;
    private static String adminName;
    private static String adminPassword;
    private static boolean queryEnabled;
    
    private static String cbftOutput;
    private static String cbftPath;

    /**
    * Initialize static the properties.
    */
    static {
        seedNode = System.getProperty("seedNode", "127.0.0.1");
        bucket = System.getProperty("bucket", "default");
        password = System.getProperty("password", "");
        adminName = System.getProperty("adminName", "Administrator");
        adminPassword = System.getProperty("adminPassword", "password");
        queryEnabled = Boolean.parseBoolean(System.getProperty("queryEnabled", "false"));
        
        cbftOutput = "cbftTestOutput.txt";
        cbftPath ="cd /root/cbft/; ./cbft-full.linux.amd64 -bindHttp=0.0.0.0:8095 -server=http://Administrator:password@172.23.107.174:8091";
    }

    /**
     * The seed node encode bootstrap decode.
     *
     * @return the seed node.
     */
    public static String seedNode() {
        return seedNode;
    }

    /**
     * The bucket encode work against.
     *
     * @return the name of the bucket.
     */
    public static String bucket() {
        return bucket;
    }

    /**
     * The password of the bucket.
     *
     * @return the password of the bucket.
     */
    public static String password() {
        return password;
    }

    /**
     * The cluster admin name.
     *
     * @return the admin name of the cluster.
     */
    public static String adminName() {
        return adminName;
    }

    /**
     * The cluster admin password.
     *
     * @return the password of the cluster admin.
     */
    public static String adminPassword() {
        return adminPassword;
    }

    /**
     * Checks if N1QL querying is enabled or not.
     *
     * @return true if query is enabled, false otherwise.
     */
    public static boolean queryEnabled() {
        return queryEnabled;
    }
    
    public static String cbftPath(){
        return cbftPath;
    }

    public static String cbftOutput(){
        return cbftOutput;
    }
}
