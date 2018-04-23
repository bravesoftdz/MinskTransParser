# MinskTransParser
MinkTrans parser (JAVA + MAVEN + SERVLET)

Parser of city transport from the site of minsktrans.by. Creation of a server with a redesigned API to obtain the transport schedule (bus, trolleybus, tram). The server accepts the request, processes the site, creates the json and renders.

The site's PDA from which data is taken: http://www.minsktrans.by/pda/

# Used libraries
1. JSOP (1.11.2)
2. GSON (2.8.2)
3. commons-lang3-3.4
4. javax.servlet-api-4.0.0

# Example usage 

get list of stops on the route:
(AJAX)
var param = {
	action : "getBusStops",
	transport : "Autobus",
	number : 37,
	day : 1
};

url : "http://************/MinskTrans/TransportStops",

Example of the result in a file.


