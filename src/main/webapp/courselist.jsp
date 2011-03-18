<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des cours</title>
</head>
<body>

<f:view>
	<h:form id="mainForm">

		<h:panelGrid columns="1">
			<rich:scrollableDataTable id="courseTable"
				binding="#{courseBean.courseTable}" value="#{courseBean.courseList}"
				var="course" width="300px" height="200px">
				<a4j:support event="onRowDblClick" action="#{courseBean.viewDetail}" />
				<rich:column id="code" width="60px">
					<f:facet name="header">
						<h:outputText value="Code" />
					</f:facet>
					<h:outputText value="#{course.code}" />
				</rich:column>
				<rich:column id="name" width="200px">
					<f:facet name="header">
						<h:outputText value="Nom" />
					</f:facet>
					<h:outputText value="#{course.name}" />
				</rich:column>
				<rich:column id="length" width="60px">
					<f:facet name="header">
						<h:outputText value="Longueur" />
					</f:facet>
					<h:outputText value="#{course.length}" />
				</rich:column>

			</rich:scrollableDataTable>
			<h:panelGroup>
				<h:commandButton value="Détail" action="#{courseBean.viewDetail}" />
				<h:commandButton value="Nouveau" action="#{courseBean.viewNew}" />
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:view>

</body>
</html>