#first time
#generate certificate
elasticsearch-certutil ca

#place them in /config/certs

#run
elasticsearch-certutil cert --ca C:\Tools\Collab\Elasticsearch\elasticsearch-9.2.3\config\certs\elastic-stack-ca.p12

#place them in /config certs


#run the following
elasticsearch-keystore add xpack.security.transport.ssl.keystore.secure_password
elasticsearch-keystore add xpack.security.transport.ssl.truststore.secure_password

#go to elastic search bin
elasticsearch.bat

#goto
http://localhost:9200
