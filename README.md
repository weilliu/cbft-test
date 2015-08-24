 cbft api unit test 
================

A unit test application for cbft REST call against cbft server 0.2.0 and Couchbase Server 4.0

*Note: The test is created based on the [cbft API reference doc](http://labs.couchbase.com/cbft/api-ref/).

## What's needed?
 - The beersample sample bucket

start cbft standalone process, for example

    ./cbft-full.linux.amd64 -bindHttp=0.0.0.0:8095 -server=http://Administrator:password@localhost:8091

To run the test, run the following command:

    mvn clean test
