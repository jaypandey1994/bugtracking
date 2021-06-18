# bugtracking

<h2>DESIGN APPROACH</h2>

1) If the third party system supports webhooks, we will add a callback url with them, which will send any update to us, and we'll process and save in our system.

2) We will poll the thirdparty system every minute or based on the throttling limit on API and get the data and store it in our system, if the third party API supports          parameter for from/to datetime, we will pass those and get limited data only, rather than fetching whole list of items.


<h3>There are multiple ways to design our API as well now</h3>

1) Expose a REST API to calculate weekly summary on runtime, and send it back to user requesting.


2) We can run a background process to aggregate the data with all the updates happening while getting the data from third party API and store the aggregated data.With this, we can just return the already aggregated weekly summary data and don't need to do re-calculations for every request

For this we can use any kind of DB either nosql like mongo

or relational db like mysql or postgres

or even something like elasticsearch or solr
