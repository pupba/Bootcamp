# 1주차 : 개발환경 세팅
## 1) JDK 1.8 설치
 - 오라클의 Java Achive에서 OS와 맞는(M1) Java 8(1.8) JDK를 설치
 - 환경변수 세팅
   1. ```vi ~/.zshrc```
   2. ```export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home```<br>```PATH=$JAVA_HOME:bin:$PATH```<br> 명령어를 쓰고 ```:wq```로 저장
 - 터미널에서 ```java -version``` 을 통해 설치 확인.
 
   ![image](https://github.com/pupba/Bootcamp/assets/53106728/97bb24b4-21c3-4248-8fde-efc42315728f)
## 2) Spring Tool Suite version 5 설치
  - Eclipse의 Plug-in으로 설치하려 했으나 STS 3(version 5)는 지원이 중단된지 좀 되었기 때문에 JDK 1.8을 지원하는 STS 3를 직접 찾아 설치.
  - https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3 에서 OS에 맞는 것을 찾아서 설치.
    
    ![image](https://github.com/pupba/Bootcamp/assets/53106728/2372d7d3-c6da-4df4-9285-ac23a4f344af)

## 3) Tomcat 9 설치
  - brew를 통해 설치
  - ```brew search tomcat```로 설치 가능한 tomcat 버전 찾기
  - ```brew install tomcat```로 최신버전, ```brew install tomcat@9``` tomcat@~로 원하느 버전 설치
  
    ![image](https://github.com/pupba/Bootcamp/assets/53106728/62109132-1691-4c55-9018-f14d64ce387b)

    ![image](https://github.com/pupba/Bootcamp/assets/53106728/e6341c83-2c01-4b80-af0d-7b81d0460f24)

    ![image](https://github.com/pupba/Bootcamp/assets/53106728/2ae025f8-ccb4-4250-8a8d-252e906ab8a6)
    
## 4) MySQL, mybatis 설치
  - MySQL 설치 및 WorkBench 테스트
    
    ![image](https://github.com/pupba/Bootcamp/assets/53106728/94350af6-f231-43c3-a2b6-83129501788b)

  - mybatis 설치
  - 
