# Practice2-Bank-Atm-Project
Practice Bank/Atm Project

Main issue- RestTemplate unable to connect between the ATM and Bank modules to get Accounts on the ATM side and send updates to the Bank side

Optimal ordering of requests in Postman:
  http://127.0.0.1:8082/createAccount/{insert name here}/{insert dollar amount here}
  http://127.0.0.1:8082/viewAccount
  http://127.0.0.1:8080/getAccount
  http://127.0.0.1:8080/withdraw/{insert withdrawal amount here}
  OR
  http://127.0.0.1:8080/deposit/{insert deposit amount here}
  http://127.0.0.1:8080/sendUpdate
  http://127.0.0.1:8082/updateAccount
