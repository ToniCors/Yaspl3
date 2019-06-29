#!/bin/bash
cd /root/Scrivania/eclipse_workspace/AntonioCorsuto/bin/

VARIABILE=$(echo $1|awk -F/ {'print $6'}|awk -F. {'print $1'})

echo "VAR:"
echo $VARIABILE



exec java -cp /root/Scrivania/eclipse_workspace/AntonioCorsuto/externalJar/java-cup-0.11a-beta-20060608-runtime.jar: main/ParserTest $1 &
for job in `jobs -p`
do
    wait $job
done
temp=$?  
if [ $temp -eq 0 ] 
then
	cd /root/Scrivania/eclipse_workspace/AntonioCorsuto/outputFile/SourceC
	exec clang -o  $VARIABILE"Compiled" $VARIABILE"Source.c"
fi
