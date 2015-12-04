#!/bin/bash

ant clear
ant dist

cp dist/persons.jar ../webapp/lib/persons.jar

cd ../webapp/

ant clear

ant deploy
