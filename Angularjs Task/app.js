(function(){
    var app = angular.module("Task",[]);
    app.controller("ContactController",function(){
        this.details=contactdetails
    });
    var contactdetails = [{
        name : "steve",
        dob : "2012-04-23",
        email : "steve@st.com",
        phoneNumber : 9874563210        
    },{
        name : "jobs",
        dob : "2000-01-02",
        email : "jobs@pyth.com",
        phoneNumber : 9785422312        
    },{
        name : "ruth",
        dob : "2015-07-10",
        email : "ruth@jax.com",
        phoneNumber : 8754213001        
    },{
        name : "radnus",
        dob : "1996-09-29",
        email : "radnus@inst.com",
        phoneNumber : 8105475462        
    }];
})();