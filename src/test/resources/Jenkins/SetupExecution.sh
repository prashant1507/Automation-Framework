#!/bin/bash
PROPERTIESFILEPATH="src/test/resources/Jenkins/FrameworkJenkins.properties"

if [[ $Url ]]; then
    sed -i'' -e "s,url='$Url',g" $PROPERTIESFILEPATH
else
    echo "Missing URL for the environment."
    exit 1
fi

if [[ $Env ]]; then
    sed -i'' -e "s,env='$Env',g" $PROPERTIESFILEPATH
else
    echo "Missing environmemnt name."
    exit 1
fi

if [[ $TesterName ]]; then
    sed -i'' -e "s,testername='$TesterName',g" $PROPERTIESFILEPATH
else
    echo "Missing testername."
    exit 1
fi

if [[ $DownloadWebDriver ]]; then
    sed -i'' -e "s,downloadwebdriver='$DownloadWebDriver',g" $PROPERTIESFILEPATH
else
    sed -i'' -e "s,downloadwebdriver=no,g" $PROPERTIESFILEPATH
fi

if [[ $RunMode ]]; then
    sed -i'' -e "s,runmode='$RunMode',g" $PROPERTIESFILEPATH
    if [[ $RemoteUrl ]]; then
        sed -i'' -e "s,remoteurl='$RemoteUrl',g" $PROPERTIESFILEPATH
    else
        echo "Missing Remote URL."
        exit 1
    fi
else
    echo "Missing Run Mode for execution."
    exit 1
fi

if [[ $UseElk ]]; then
    sed -i'' -e "s,useelk='$UseElk',g" $PROPERTIESFILEPATH
    if [[ $ElasticSearchUrl ]]; then
        sed -i'' -e "s,elksuiteurl='$ElasticSearchUrl',g" $PROPERTIESFILEPATH
    else
        echo "Missing ELK URL."
        exit 1
    fi
else
    sed -i'' -e "s,useelk=no,g" $PROPERTIESFILEPATH
fi

if [[ $DeleteReports ]]; then
    sed -i'' -e "s,deleteoldreports='$DeleteReports',g" $PROPERTIESFILEPATH
    if [[ $NumberOfDays ]]; then
        sed -i'' -e "s,numberofdays='$NumberOfDays',g" $PROPERTIESFILEPATH
    else
        sed -i'' -e "s,numberofdays=10,g" $PROPERTIESFILEPATH
    fi
else
    sed -i'' -e "s,deleteoldreports=no,g" $PROPERTIESFILEPATH
fi

if [[ $OverRideReports ]]; then
    sed -i'' -e "s,overridereports='$OverRideReports',g" $PROPERTIESFILEPATH
else
    sed -i'' -e "s,overridereports=no,g" $PROPERTIESFILEPATH
fi

if [[ $TakeScreenShotForPass ]]; then
    sed -i'' -e "s,passedscreenshot='$TakeScreenShotForPass',g" $PROPERTIESFILEPATH
else
    sed -i'' -e "s,passedscreenshot=no,g" $PROPERTIESFILEPATH
fi

if [[ $RetryFailedTestCase ]]; then
    sed -i'' -e "s,retryfailedtestcases='$RetryFailedTestCase',g" $PROPERTIESFILEPATH
else
    sed -i'' -e "s,retryfailedtestcases=no,g" $PROPERTIESFILEPATH
fi

if [[ $SendMailAfterExecution ]]; then
    sed -i'' -e "s,sendmailafterexecution='$SendMailAfterExecution',g" $PROPERTIESFILEPATH
    if [[ $MailServerName ]]; then
        sed -i'' -e "s,sendmailusing='$MailServerName',g" $PROPERTIESFILEPATH
    else
        echo "Missing Mail Server Name."
        exit 1
    fi
    if [[ $SenderEmailID ]]; then
        sed -i'' -e "s,emailid='$SenderEmailID',g" $PROPERTIESFILEPATH
    else
        echo "Missing Sender's Email ID."
        exit 1
    fi
    if [[ $SenderPassword ]]; then
        sed -i'' -e "s,emailpassword='$SenderPassword',g" $PROPERTIESFILEPATH
    else
        echo "Missing Sender's Password in Base64Encode."
        exit 1
    fi
    if [[ $ReceiverMailID ]]; then
        sed -i'' -e "s,receiversemailid='$ReceiverMailID',g" $PROPERTIESFILEPATH
    else
        echo "Missing Receiver's Email ID."
        exit 1
    fi
else
    sed -i'' -e "s,sendmailafterexecution=no,g" $PROPERTIESFILEPATH
fi