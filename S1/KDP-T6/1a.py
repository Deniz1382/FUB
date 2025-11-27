def matrix_summe_allgemein(mymatrix):
	sum=0
	for i in range(len(mymatrix)):
		for j in range(len(mymatrix[0])):
			sum+=mymatrix[i][j]
	return sum

example=[
	[1,2,3],
	[4,5,6],
	[7,8,9]
]
print(matrix_summe_allgemein(example))

