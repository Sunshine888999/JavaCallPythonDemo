# coding=utf-8
import sys

def sum(a, b):
    print(int(a) + int(b))

if __name__ == '__main__':
    sum(sys.argv[1], sys.argv[2])