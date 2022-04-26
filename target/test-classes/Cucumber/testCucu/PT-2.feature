Feature: Naviguer sur Google et rechercher un mot

	#1er test � r�aliser
	@TEST_PT-2
	Scenario: Naviguer sur Google et rechercher un mot
		Feature: Naviguer sur un site web
		 er Test a realiser pour naviguer sur un site web
		 
		  Example: premier test
		    Given Ouvrir et lancer firefox
		    When Je cherche pour le mot "viande"
		    Then Le titre de la page doit commencer par "viande"
