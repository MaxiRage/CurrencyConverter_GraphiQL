# CurrencyConverter_GraphiQL
App for currency conversion with the current rates of the Central Bank

При запуске приложения происходит обновление курса валют с http://www.cbr.ru/scripts/XML_daily.asp

Для создания запроса на обмен или получения курсов валют используйте GraphQL IDE по ссылке http://localhost:8080/graphiql

**Для доступа к базе данных используйте:** <br> 
url: jdbc:postgresql://localhost:5432/Converter <br> 
username: postgres <br> 
password: admin

***Примеры:***

Для запроса всех валют:
> query { <br> 
   allCurrency {<br> 
    name,<br> 
    charCode,<br> 
    numCode,<br> 
    nominal,<br> 
    value 
  <br> }<br> 
}<br> 

Для проведения операции конвертации:
> query {<br>
	currencyExchange(nameBefore:"Российский рубль", <br>
    nameAfter: "Доллар США", <br>
    volumeSale: 10000) <br>
  {<br>
	  id,<br>
    rate,<br>
    result<br>
	} <br>
}

Для просмотра всех операций:

> query { <br>
  allTransactions {<br>
    id,<br>
    initialCurrency{<br>
      name,<br>
      charCode<br>
    },<br>
    rate,<br>
    finalCurrency {<br>
      name,<br>
      charCode<br>
    },<br>
    volume,<br>
    result<br>
  }<br>
}
