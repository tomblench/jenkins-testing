/**
 * Created by tomblench on 08/09/2017.
 */

import org.eclipse.jgit.lib.TagBuilder;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.storage.file.*;
import org.eclipse.jgit.revwalk.*;
import org.eclipse.jgit.api.*;

print "hello world"

def builder = new FileRepositoryBuilder();
def repository = builder.setGitDir(new File("/Users/tomblench/cloudant_dev/jenkins-testing/.git"))
        .readEnvironment() // scan environment GIT_* variables
        .findGitDir() // scan up the file system tree
        .build();

//print repository

def head = repository.resolve("HEAD");

//print head

Ref HEAD = repository.getRef("refs/heads/master");

//print HEAD

RevWalk walk = new RevWalk(repository);

//print walk

RevCommit commit = walk.parseCommit(head);

print "commit ${commit}"

def tc = new TagCommand(repository)

tc.setObjectId(commit).
   setMessage("testing 123").
   setName("floof").
        call()

