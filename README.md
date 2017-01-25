# Belajar2

http://31.220.58.88/dotsol/test.php = 1 array berhasil

http://31.220.58.88/dotsol/test.php?p=2 = 2 array gagal

**link json** http://31.220.58.88/dotsol/test.php

script

<pre><?php

if(isset($_GET['p']) && $_GET['p']==2)
{
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
}
else
{
	$a = array(
			'nama'=>'anto',
			'kota'=>'jakarta'
		);
}
echo json_encode($a);
?></pre>
