package external.web.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "external.web.portlet.ExternalWebConfiguration", localization = "content/Language", name = "external-web-configuration-name")
public interface ExternalWebConfiguration {

	@Meta.AD(deflt = "1", description = "autosave-interval-description", name = "autosave-interval-name", required = false)
	public int autosaveInterval();

	@Meta.AD(deflt = "descriptive", name = "default-display-view", optionLabels = { "Descriptive",
			"List" }, optionValues = { "descriptive", "list" }, required = false)
	public String defaultDisplayView();

}
