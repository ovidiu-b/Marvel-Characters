Material Characters

A Multi Modular Android Application showing a list of Marvel characters and his details. 

In order to run this application, an apikey.properties file is required. Place it in the root proyect. 

This file will contain the public and private keys provided by your Marvel developer account.

Example:

PUBLIC_KEY="XXXXXXXXX"
PRIVATE_KEY="XXXXXXXXXXXXXXXXXXXXXX"


Structured using Clean Architecture + MVVM

Modules:

	-app: dagger graph, main navigation activity, unit and android test related classes
	
	-buildSrc: gradle utilities, as well as all the dependencies paths and versions used in the app
	
	-common: common utilities used across the modules
	
	-data:
		-config: configuration data, like app settings or session data. 
		-datasource: local and remote contracts
		-local: room entities, daos and room database
		-model: business logic data classes
		-remote: retrofit instance, api calls, dtos, mappers from dto to bo
		-repository: repositories classes which encapsulate the calls from local or remote
		
	-features: 
		-character: the character feature, including all the fragments, viewModels, adapters, view bindings, etc.
		
	-navigation: navigation component utility classes

