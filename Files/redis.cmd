docker run -d -p 6379:6379 --name redis redis:7

run redis container
docker run -d --name redis -p 6379:6379 redis


#add this before @SpringbootApplication
@EnableCaching

#Add redis and cache configurations in pom.xml
		<!-- Redis -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>

		<!-- caching -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>

#define redis and cache in application.yaml
  redis:
    host: localhost
    port: 6379

  cache:
    type: redis

#In serviceImpl give @Cacheable, @Cacheput @CacheEvict for methods that perform gte, update,delete operations respectively

#check if redis container active on docker
docker ps -a

#if you see redis execute the following command
docker start redis

#open redis cli using docker
docker exec -it redis redis-cli

#give PING
#you should see PONG

#execute the following commands
KEYS *

#commands for redis without docker
#run redis server
redis-server

#start application
springboot:run

#open redis cli
redis-cli

#list all keys
redis-cli keys *

#we will see the following
documents::101
documents::102

#give the following command
GET documents::101


#we might see unreadable json data
#check keys
TTL documents::101


