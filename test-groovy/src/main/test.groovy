/**
 * Created by tomblench on 08/09/2017.
 */

import org.eclipse.jgit.lib.TagBuilder;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.storage.file.*;
import org.eclipse.jgit.revwalk.*;

print "hello world"

def builder = new FileRepositoryBuilder();
def repository = builder.setGitDir(new File("."))
        .readEnvironment() // scan environment GIT_* variables
        .findGitDir() // scan up the file system tree
        .build();

def head = repository.resolve("HEAD");

//Ref HEAD = repository.getRef("refs/heads/master");

RevWalk walk = new RevWalk(repository);
RevCommit commit = walk.parseCommit(head);

new TagBuilder().setObjectId(commit)