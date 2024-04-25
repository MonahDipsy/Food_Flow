const functions = require('firebase-functions');
const admin = require('firebase-admin');
const nodemailer = require('nodemailer');

// Initialize admin app (replace with your Firebase project credentials)
admin.initializeApp();
const db = admin.database(); // Reference to Realtime Database

// Configure email transporter
const transporter = nodemailer.createTransport({
  host: process.env.EMAIL_HOST,
  port: process.env.EMAIL_PORT,
  secure: false, // Upgrade to `true` for a secure connection (TLS)
  auth: {
    user: process.env.EMAIL_USER,
    pass: process.env.EMAIL_PASSWORD,
  },
});

exports.onDonation = functions.database
  .ref('/donations/{donationId}')
  .onCreate(async (snapshot, context) => {
    const donationData = snapshot.val();

    // Send email notification (without sanitization)
    const mailOptions = {
      from: process.env.EMAIL_USER,
      to: donationData.donorEmail,  // Potential security risk
      subject: 'Donation Received!',
      text: `... (rest of the email content using donationData)`,
    };

    transporter.sendMail(mailOptions)
      .then(() => console.log('Email sent successfully'))
      .catch((error) => console.error('Error sending email:', error));
  });
