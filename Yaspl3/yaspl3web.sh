#!/bin/bash
cd /root/Scrivania/eclipse_workspace/AntonioCorsuto/bin

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
	exec clang -S -emit-llvm $VARIABILE"Source.c" &
	for job in `jobs -p`
	do
    		wait $job
	done
	temp=$?  
	if [ $temp -eq 0 ]
	then 
		cd /emsdk/emscripten/1.38.25
		exec ./emcc /root/Scrivania/eclipse_workspace/AntonioCorsuto/outputFile/SourceC/$VARIABILE"Source.ll" -s WASM=0 -o /root/Scrivania/eclipse_workspace/AntonioCorsuto/outputFile/WebCode/$VARIABILE"Web.html"
	fi
fi
