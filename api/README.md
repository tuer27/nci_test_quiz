# TKDConnect API

This project contains the back end implementation of the TKD Connect application.

## Install

### Java JDK
Download [JDK 8] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)<br/>
Add the path to JAVA JDK bin to Path environment variable<br/>
Add JAVA_HOME environment variable that points to the JAVA JDK directory<br/>

### Tomcat
Download [Tomcat 8.0] (http://tomcat.apache.org/download-80.cgi)<br/>
Setup tomcat<br/>
<ul>
	<li>Set Global JNDI in server.xml</li>
	<li>Set DataSourceRealm in server.xml</li>
	<li>Set up keystore<br/>
		<code>keytool -genkey -alias tomcat -keyalg RSA</code></li>
	<li>Turn SSL in server.xml</li>
	<li>mkdir lib\properties</li>
	<li>copy paypal.properties from tkdconnect-api to the lib\properties</li>
	<li>replace the paypal credentials with the one provided in slack</li>
	<li>copy mail.properties from tkdconnect-api to the lib\properties</li>
	<li>replace the mail credentials with the one provided in slack</li>
	<li>copy resource.properties from tkdconnect-api to the lib\properties</li>
	<li>replace the path with the directory where you would like to keep the file attachments</li>
</ul>

### Maven
Download [Maven] (https://maven.apache.org/download.cgi)<br/>
Extract in a directory<br/>
Add the path to Maven bin to Path environment variable<br/>

### Eclipse (Optional)
Download Eclipse Neon (Optional)<br/>
<ul>
	<li>AngularJS</li>
	<li>EGit</li>
	<li>M2E Maven</li>
</ul>


## Build

Run 
<code>mvn package</code>

## Deployment
Run
<code>mvn tomcat7:redeploy</code>
