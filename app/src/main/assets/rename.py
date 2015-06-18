import os

nums = ["one", "two", "three","four","five","six","seven","eight","nine","ten","jack","queen","king"]
suite = ["diamonds","spades","hearts","clubs"]


for f in os.listdir("."):

	if f == "rename.py":
		continue
	# x = ""
	# if f.endswith(".png"):
	# 	for s in suite:
	# 		if s in f:
	# 			x += s
	# 			break

	# 	for i in nums:
	# 		if i in f:
	# 			x += "-" + i
	# 			break

	# 	# print x
	# 	# if len(s)>3:

	x = f.replace("suite_1","suite1")


	try:
		os.rename(f, x)
	except:
		pass
		# os.rename("." + f, x)
		# os.rename(f, s)

