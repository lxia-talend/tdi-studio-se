%~d0
cd %~dp0
java -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} ${talend.job.class} ${talend.job.context} ${talend.job.bat.addition} %* 