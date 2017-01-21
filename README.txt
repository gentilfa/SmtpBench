Create war:

Mavel Compiler 3.5.1
JDK 1.8

Command mvn clean install


Deploy on Tomcat (developer version 8.5)
Start application: http://<HOST>:<PORT>/SmtpBench

Param Application to execute procedure:

user:username (usually without domain)
pass:password
host:host smtp
port:port smtp
portSSL:port to ssl autenticator
mailTo:address receiver
mailFrom:adress sender
numThread:number of thread
numMess:number message to send
sizeMessage1: size of message
sizeMessage2: other size of message (optional)
sizeMessage3: other size of message (optional)