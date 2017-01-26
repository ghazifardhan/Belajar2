# Belajar2

link json : 128.199.226.96/test/test.php

script

```
<?php

header('Content-type: application/json');

$a = array(
        array(
            'nama'=>'anto',
            'kota'=>'jakarta'
        ),
        array(
            'nama'=>'doni',
            'kota'=>'semarang'
        )
);

$data = array("data" => $a);



echo json_encode($data);
?>
```
