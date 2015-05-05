#!/bin/bash

echo "Removing memories"
for ipc in $(ipcs -m|grep $USER|cut -f 2 -d " ")
do
    ipcrm -m $ipc
    echo "."
done


echo "Removing Semaphores"
for ipc in $(ipcs -s|grep $USER|cut -f 2 -d " ")
do
    ipcrm -s $ipc;
    echo "."
done
