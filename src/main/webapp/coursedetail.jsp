<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Détail d'un cours</title>
</head>
<body>
<f:view>
	<h:form id="mainForm">

		<h:panelGrid columns="2">
			<h:outputLabel value="Code" for="code" />
			<h:inputText id="code" value="#{courseBean.currentCourse.code}" />
			<h:outputLabel value="Nom" for="name" />
			<h:inputText id="name" value="#{courseBean.currentCourse.name}" />
			<h:outputLabel value="Durée" for="length" />
			<h:inputText id="length" value="#{courseBean.currentCourse.length}" />
			<h:outputLabel value="Professeur" for="teacher" />
			<h:inputText id="teacher"
				value="#{courseBean.currentCourse.teacher.name}" readonly="true"/>
				
			<h:panelGroup />
			<h:panelGroup >
				<h:commandButton value="Enregistrer" action="#{courseBean.update}"/>
				<h:commandButton value="Retour" action="list" immediate="true"/>
			</h:panelGroup >
		</h:panelGrid>
	</h:form>
</f:view>

</body>
</html>