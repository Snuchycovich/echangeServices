#!/bin/bash

ant clear
ant dist

cp dist/services.jar ../webapp/lib/services.jar

cd ../webapp/

ant clear

ant deploy
