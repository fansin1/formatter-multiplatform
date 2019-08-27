# formatter-multiplatform
Library, that format data to table.
That version can be used in any Kotlin project (JVM, JS, Native...)

#### Sample:

```
val tableFormatter = TableFormatter.create(AsciiBorderFormatter())

tableFormatter.addRow("Test", "test", "testet")
tableFormatter.addRow("ter", "te")
tableFormatter.addRow(123, 13, 123)
tableFormatter.addRow(123.123, 12.0, "test", 123)
tableFormatter.removeAt(2)

print(tableFormatter.format())
```

#### Result:

```
+-------+----+------+---+
|Test   |test|testet|   |
+-------+----+------+---+
|ter    |te  |      |   |
+-------+----+------+---+
|123.123|12.0|test  |123|
+-------+----+------+---+
```

## Another border formatters:
 
#### `EmptyBorderFormatter`
 
It places `'\t'` between columns.
It can be useful for opening in `Excel` or same programs.

#### Result:

```
Test   	test	testet	
ter    	te  	
123.123	12.0	test  	123
```

#### `UnicodeBorderFormatter`

That BorderFormatter using custom `BorderCharacters`

```
TableFormatter.create(UnicodeBorderFormatter(BorderStyle.DEFAULT.borderCharacters))

╔═══════╤════╤══════╤═══╗
║Test   │test│testet│   ║
╠═══════╪════╪══════╪═══╣
║ter    │te  │      │   ║
╟───────┼────┼──────┼───╢
║123.123│12.0│test  │123║
╚═══════╧════╧══════╧═══╝
```
