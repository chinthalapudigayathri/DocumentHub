#go to /logstash/bin
#logstash.bat -f C:\Tools\Collab\Logstash\logstash-9.2.3\config
#Run the following command only
logstash -f config/logstash.conf
# you can check the log on kibana
http://localhost:9200/_cat/indices?v