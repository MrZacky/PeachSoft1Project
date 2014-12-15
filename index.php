<?php
$host="localhost";
$port="5432";
$user="student";
$haslo="moje_haslo";
$baza="moja_DB";
if (! $dbh = pg_pconnect("host=$host port=$port user=$user
         password=$haslo dbname=$baza"))
   echo "Nie mogę się połączyć z bazą danych";
else
   {
    $tabelka="produkty";
    $query="select * from $tabelka;";
    if($wynik=pg_query($query))
       {
        $licznik=pg_num_rows($wynik);
        echo "<html>";
        echo "<H2> Dane z tabeli $tabelka: </H2>";
       $li=0;
       while($li++<$licznik)
     {
      $linia=pg_fetch_row($wynik,$li);
      echo "$linia[0] $linia[1] <br>";
     }
       echo "</html>";
      }
    else
      echo "Brak danych...";
   }
?>
