# unicorn
unicorn,elastic-job-lite spring boot2.x starter

# UseAge

  pom.xml
  
          <dependency>
              <groupId>com.sangoes.unicorn</groupId>
              <artifactId>elastic-spring-boot-starter</artifactId>
              <version>1.0</version>
          </dependency>
  
          <dependency>
              <groupId>com.dangdang</groupId>
              <artifactId>elastic-job-lite-spring</artifactId>
              <version>2.1.5</version>
          </dependency>  
  
  application.yml
  
      sangoes:
        elastic:
          zookeeper:
            serverLists: 127.0.0.1:2181
            namespace: 0=Beijing,1=Shanghai,2=Guangzhou
            
