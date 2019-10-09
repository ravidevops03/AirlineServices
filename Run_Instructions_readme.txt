============================ Requirements ===========================================

Eclipse - String Tool Suite (3.9.9)
Java    - 1.8
Maven   - 3.0.5

============================ Pre-run steps ==========================================
Ensure that there no other application that is running on port 7077 before performing the below steps.


Run instructions:
There are couple of ways you can run this project.

========================== Run as main class from STS tool =========================
1. Open Airline-Services-API project in STS ide
2. Right click on Java file com.airline.service.api.Application.java -> Run as -> Java Application. 
3. Then a web container will automatically be started on 7077 port.
4. We can now access the REST services. (Refer to document - AirlinesServicesRESTServices_V1.0.docx)
5. Filter of Flight details from mock Airlines Service response is based on origin and destination airport parameter.
   
====================================================================================


========================== Run as Application from STS tool ================================
1. Open Airline-Services-API project in STS ide
2. Right click on Project -> Run as -> Spring Boot App. 
3. Then a web container will automatically be started on 7077 port.
4. We can now access the REST services. (Refer to document - AirlinesServicesRESTServices_V1.0.docx)
5. Filter of Flight details from mock Airlines Service response is based on origin and destination airport parameter.

====================================================================================


========================== Running Junit Test cases ================================
1. In the eclipse, go to the java class APIUtilTests.java
2. right click and Run as -> JUnit Test
3. Junit tests will also be run automatically when you try to generate an executable from the STS ide.
===================================================================================


