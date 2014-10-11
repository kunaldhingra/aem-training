package cr.prodigious.aem.breadcrumb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.day.cq.wcm.api.Page;

import cr.prodigious.aem.breadcrumb.model.BreadcrumbLink;

public class BreadcrumbController {

	/**
	 * Method to get the breadcrumb links.
	 * 
	 * @param page
	 *            Actual page
	 * 
	 * @return List of links
	 */
	public List<BreadcrumbLink> getBreadcrumb(Page page) {
		List<BreadcrumbLink> links = new ArrayList<BreadcrumbLink>();

		Page actualPage = page;

		while (actualPage != null) {
			links.add(getBreadcrumbLinkFromPage(actualPage));
			actualPage = actualPage.getParent();
		}

		Collections.reverse(links);

		return links;
	}

	/**
	 * Method to adapt a page into a BreadcrumbLink object.
	 * 
	 * @param page
	 *            Actual Page
	 * 
	 * @return BreadcrumbLink object
	 */
	private BreadcrumbLink getBreadcrumbLinkFromPage(Page page) {
		BreadcrumbLink newBreadcrumbLink = new BreadcrumbLink();

		newBreadcrumbLink.setLink(page.getPath());
		newBreadcrumbLink.setTitle(page.getTitle());

		return newBreadcrumbLink;
	}
}
