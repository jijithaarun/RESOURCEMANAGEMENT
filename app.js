const express = require("express");
const cors = require("cors");
const bodyParser = require("body-parser");
const nodemailer = require("nodemailer");

const details = require("./details.json");

const app = express();
app.use(cors({ origin: "*" }));
app.use(bodyParser.json());

//Send Mail ---2
app.listen(3000, () => {
    console.log("The server started on port 3000 !!!!!!");
});

app.get("/", (req, res) => {
    res.send(
        "<h1 style='text-align: center'>Welcome to RMS v2020 Sending mails </h1>"
    );
});

//Send Mail --2 End
app.post("/sendmail", (req, res) => {
    console.log("request came");
    let user = req.body;
    sendMail(user, info => {
        console.log(`The mail has been sent and the id is ${info.messageId}`);
        res.send(info);
    });
});

async function sendMail(user, callback) {
    // create reusable transporter object using the default SMTP transport
    let transporter = nodemailer.createTransport({
        host: "smtp.gmail.com",
        port: 587,
        secure: false, // true for 465, false for other ports
        auth: {
            user: details.email,
            pass: details.password
        }
    });

    let mailOptions = null;
    //console.log(user.action);
    if (user.action === "Y") {
        mailOptions = {
            from: '"faith "<faithinfotech4@gmail.com>', // sender address
            to: user.email, // list of receivers
            subject: "BOOKING CONFIRMED...", // Subject line
            html: `<h3>Dear ${user.name}</h3>
      <h4>Thank you for choosing <b>${user.resourcename}</b>.<br>
      <h4> We are pleased to confirm your booking.</h4>`
        };
    }
    else {
        mailOptions = {
            from: '"faith "<faithinfotech4@gmail.com>', // sender address
            to: user.email, // list of receivers
            subject: "BOOKING CANCELLED!!!", // Subject line
            html: `<h3>Dear ${user.name}</h3>
      <h4>Thank you for choosing <b>${user.resourcename}</b>.<br>
      <h4> We are regretted to cancel your booking.</h4>`
        };
    }

    // send mail with defined transport object
    let info = await transporter.sendMail(mailOptions);
    callback(info);
}