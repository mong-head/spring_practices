# File Upload Test

* 설정

	* pom.xml
		* spring context, mvc, web-mvc
		* jstl
		* servlet
		* common FileUpload 설정
	* spring-servlet.xml
		* file upload 관련 설정
			* multipartResolver 설정
			* file upload mapping 관련 설정
	* applicationContext.xml
	
* MultipartResolver
	* spring 내에 위치
	* common file upload library사용
	
* FileUploadService restore

### 파일 저장시
1. 파일 이름 중복되지 않게 만들기
2. table만들기
3. mapping (물리적 upload-images 파일과 DB 컬럼내에서 경로)