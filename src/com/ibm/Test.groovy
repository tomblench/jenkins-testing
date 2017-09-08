#!groovy

@Grab('org.eclipse.jgit:org.eclipse.jgit:4.8.0.201706111038-r')

import org.eclipse.jgit.lib.TagBuilder;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.storage.file.*;
import org.eclipse.jgit.revwalk.*;
import org.eclipse.jgit.api.*;

def doTag(String directory) {

    def builder = new FileRepositoryBuilder();

    print ("files\n")
    print (new File(".").list().join(", "))
    
    def repository = builder.setGitDir(new File(".git"))
    .readEnvironment() // scan environment GIT_* variables
    .findGitDir() // scan up the file system tree
    .build();

    //print repository
    
    def head = repository.resolve("HEAD");

    print head

    Ref HEAD = repository.getRef("refs/heads/master");

    print HEAD

    RevWalk walk = new RevWalk(repository);

    print walk

    RevCommit commit = walk.parseCommit(head);

    print "commit ${commit}"
    
    
}
