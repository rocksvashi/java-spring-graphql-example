### Documentation
After, scratching my head around the GraphQl for sometime, I decided to put up an example which can demonstrate,
how to setup and use GraphQl with Spring. In this example I have tried to use a public REST API endpoints as Data Fetcher source. The current example demonstrate only the "Query" type, The mutation part is in progress. Stay tuned!!!

If you want to contribute to this example, send me a pull request.

```js
# Schema https://jsonplaceholder.typicode.com/
#Fetch User,  Also can fetch Todo List, Albums created by that user along with photos information in the Album.
{
	user (id: 1){
		name
		email
		albums {
			title
			id
			photos {
				title
				url
			}
		}
		todos{
				title
		}
	}

}

# Fetch Post(s) along with Comments.
{
	post (id: 1){
		title
		comments {
			name
		}
	}

}





### DISCLAIMER
All data and information provided on this EXAMPLE is for informational purposes only. This EXAMPLE makes no representations as to accuracy, completeness, correctness, suitability, or validity of any information on this EXAMPLE and will not be liable for any errors, omissions, or delays in this information or any losses, injuries, or damages arising from its display or use. All information is provided on an as-is basis.
The opinions expressed here represent my own and not those of my employer or any other organization.


### Acknowledgment

This implementation is based on the [GraphQL Java ](http://graphql-java.readthedocs.io/en/v7/schema.html).
Also, for schema, the following free public [REST API] is used(https://jsonplaceholder.typicode.com/)


### License
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 2, December 2004

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>

 Everyone is permitted to copy and distribute verbatim or modified
 copies of this license document, and changing it is allowed as long
 as the name is changed.

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

  0. You just DO WHAT THE FUCK YOU WANT TO.
