/*******************************************************************************
 *Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 *Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 *Proprietary and confidential
 ******************************************************************************/

function QuestionsList() {
	this.questionList;
}
	
function AnswersList() {
	this.answersList;
}

function QuestionData() {
  this.id = "";
  this.ord = "";
  this.description = "";
  this.shortName = "";
  this.answer = "";
  this.type = "SINGLE_ANSWER";
  this.uuid = "";
}

function AnswerData() {
  this.id = "";
  this.ord = "";
  this.answerDescription = "";
  this.groupName = "";
  this.answerValuesArray = new Array();
  this.type = "RADIO";
  this.answerColumnHeading = "";
  this.answerDisplayStyle = "";
  this.answerConstraintsArray = new Array();
  this.uuid = "";
}

function AnswerValue() {
  this.id = "";
  this.formId = "";
  this.answerValueDescription = "";
  this.answerValue = "";
  this.shortname = "";
  this.permanentId = "";
  this.ord = "";
  this.answerDisplayStyle = "";
  this.defaultValue = false;
}

function Constraint() {
	this.name = "";
	this.value = "";
}