cd personslib
ant clear
ant dist
cp dist/persons.jar ../webapp/lib
cd ../services
ant clear
ant dist
cp dist/services.jar ../webapp/lib
cd ../webapp
ant clear
ant deploy
