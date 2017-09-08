#!groovy

@Library('testlib')
import com.ibm.Test
node {
    checkout scm
    def workspace = pwd()
    print "workspace ${workspace}\n"

    def t = new Test(workspace)
    t.doTag()
}
