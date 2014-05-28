package com.aspire.demo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class SimpleCassandraClient {

	private Cluster cluster;

	public void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node).build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(),
					host.getRack());
		}
	}
	
	public Cluster getCluster() {
		return cluster;
	}
	
	public Session getSession(String ks) {
		
		Session s = cluster.connect();
		s.execute("use " + ks);
		return s;
	}
}
