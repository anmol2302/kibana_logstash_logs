# kibana_logstash_logs

<br/>
Start Elasticsearch,kibana,logstash<br/>
uncomment the path in kibana for elasticsearch.url<br/>
then add the properties in  logstash conf file <br/>

````
input {
  file {
    type => "java"
    path => "{{path to log file}}"
    codec => multiline {
      pattern => "^%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME}.*"
      negate => "true"
      what => "previous"
    }
  }
}
 
 
filter {
  #If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
  if [message] =~ "\tat" {
    grok {
      match => ["message", "^(\tat)"]
      add_tag => ["stacktrace"]
    }
  }
 
}
 
output {
  stdout {
    codec => rubydebug
  }
 
  # Sending properly parsed log events to elasticsearch
  elasticsearch {
    hosts => ["localhost:9200"]
  }
  }
  ````


<br/>
set the log4j properties carefully in application.properties file.</br> 
and start the service go to kibana set the index and <br/>
and good to go.
use this link for further use :
``
https://www.javainuse.com/spring/springboot-microservice-elk 

``
