# Contribution Guidelines

This documentation contains a set of guidelines to help you during the contribution process. 
We are happy to welcome all the contributions from anyone willing to try to fix vulnerable codes.


## Step 1 : Fork the Project

- Fork this Repository. This will create a Local Copy of this Repository on your Github Profile. Keep a reference to the original project in `upstream` remote.

![[fork.png]]

```sh
git clone https://github.com/<your-username>/<github-project>
cd <github-project>
git remote add upstream https://github.com/projectdiscovery/<github-project>
```

- If you have already forked the project, update your copy before working.

```sh
git remote update
git checkout master
git rebase upstream/master
```

## Step 2 : Create your  Branch

Create a new branch. Use its name to identify the issue your addressing.

```sh
# It will create a new branch with name <branch_name> and switch to that branch
git checkout -b <branch_name>
```

## Step 3 : Fix vulnerable code and Commit

- fix the code.
- Add all the files/folders needed.
- add changes to the branch you've just created by:

```sh
# To add all new files to branch
git add .
```

- To commit, give a descriptive message for the convenience of the reviewer by:

```sh
# This message get associated with all files you have changed
git commit -m "Added/Fixed/Updated by <your username>"
```


## Step 4 : Push Your Changes

- Now you are ready to push to the remote (forked) repository.

```sh
# To push your work to your remote repository
git push -u origin <branch_name>
```

## Step 5 : Pull Request

- Navigate to your GitHub repository, then click on the New pull request button within the Pull requests tab. Provide a name and description to your pull request.
