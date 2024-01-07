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
  - STS3로 JDK1.8에서 프로젝트를 만들때 이상하게 다음과 같은 오류<br>
    ```An error has occurred. See error log for more details.java.lang.ExceptionInInitializerError```<br>
    가 뜰 수 있다. 이는 STS의 문제로 STS.ini 파일을 수정해줘야 한다.

     
## 3) Tomcat 9 설치
  - brew를 통해 설치
  - ```brew search tomcat```로 설치 가능한 tomcat 버전 찾기
  - ```brew install tomcat```로 최신버전, ```brew install tomcat@9``` tomcat@~로 원하느 버전 설치
  
    ![image](https://github.com/pupba/Bootcamp/assets/53106728/62109132-1691-4c55-9018-f14d64ce387b)

    ![image](https://github.com/pupba/Bootcamp/assets/53106728/e6341c83-2c01-4b80-af0d-7b81d0460f24)

    ![image](https://github.com/pupba/Bootcamp/assets/53106728/2ae025f8-ccb4-4250-8a8d-252e906ab8a6)
    
## 4) Mariadb, mybatis, DAO, Service, VO 
  - Mariadb 설치 및 WorkBench 테스트
    * Mac에서 brew를 통한 MariaDB 설치 후 접속 계정 생성 
    
    ![image](https://github.com/pupba/Bootcamp/assets/53106728/94350af6-f231-43c3-a2b6-83129501788b)

  - mybatis 설치
    * mybatis plug-in 1.2.5 버전 부터는 STS 3.9.X를 망가 뜨린다. 다음 링크를 참고하여 직접 넣기.
      -> https://e-7-e.tistory.com/67  
    * 앞에 과정 후 수행 -> https://level-rosehip-002.notion.site/1-6-Mariadb-MyBatis-c502f792d334424894772947df61e122
  - pom.xml을 수정하면 해야하는 내용 --> https://hijjang2.tistory.com/658 (이 과정을 해줘야 maven 의존성이 추가됨.)
  - DAO, Service, VO 파일 작성

    * DAO
      ```
      // MovieDAO.java 선언부(인터페이스)
      package com.comento.dao;
      import java.util.List;
      import com.comento.vo.MovieVO;
      
      public interface MovieDAO {
      	public List<MovieVO> selectMovie() throws Exception;
      }
      
      // MovieDAOImpl.java 구현부
      package com.comento.dao;
      import java.util.List;
      import javax.inject.Inject;
      import org.apache.ibatis.session.SqlSession;
      import org.springframework.stereotype.Repository;
      
      import com.comento.vo.MovieVO;
      
      @Repository
      public class MovieDAOImpl implements MovieDAO{
          @Inject
          private SqlSession sqlSession;
          private static final String Namespace = "com.comento.mybatis.sql.test";
    
          @Override
          public List<MovieVO> selectMovie() throws Exception {
       
              return sqlSession.selectList(Namespace+".selectMovie");
          }
 
      }
      ```
    * Service
      ```
      // MovieService.java 선언부(인터페이스)
      package com.comento.service;
      import java.util.List;
      import com.comento.vo.MovieVO;
       
      public interface MovieService {
          public List<MovieVO> selectMovie() throws Exception;
      }
      
      // MovieServiceImpl.java 구현부
      package com.comento.service;
      import java.util.List;
      import javax.inject.Inject;
      import org.springframework.stereotype.Service;
       
      import com.comento.dao.MovieDAO;
      import com.comento.vo.MovieVO;
       
      @Service
      public class MovieServiceImpl implements MovieService {
       
          @Inject
          private MovieDAO dao;
          
          @Override
          public List<MovieVO> selectMovie() throws Exception {
       
              return dao.selectMovie();
          }
       
      }
      ```
    * VO
      ```
      package com.comento.vo;
      
      public class MovieVO {
      	private int movie_id;
      	private String movie_name;
      	private String director;
      	private String types;
      	// private String moviecol;
      	public int getMovie_id() {
      		return movie_id;
      	}
      	public void setMovie_id(int movie_id) {
      		this.movie_id = movie_id;
      	}
      	public String getMovie_name() {
      		return movie_name;
      	}
      	public void setMovie_name(String movie_name) {
      		this.movie_name = movie_name;
      	}
      	public String getDirector() {
      		return director;
      	}
      	public void setDirector(String director) {
      		this.director = director;
      	}
      	public String getTypes() {
      		return types;
      	}
      	public void setTypes(String types) {
      		this.types = types;
      	}
      	
      }
      ```
## 5) jsp를 사용하여 확인
![image](https://github.com/pupba/Bootcamp/assets/53106728/02fe1b32-4839-4587-b7b6-b8135de0ba71)
