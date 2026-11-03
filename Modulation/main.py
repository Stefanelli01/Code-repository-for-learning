import operations
from operations import multi
from operations import add
import operations as op


result = operations.add(10,5)
print(result)

result = multi(10,5)
print(result)

result = op.sub(10,5)
print(result)

if __name__ == "__main__":
    print("Modulação")
    print(add(2,2))