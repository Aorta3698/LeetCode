Eze (Won't ask for payment) Cheezy, [5/26/2022 7:54 AM]
// Start shipment
$shipment = new Ups\Entity\Shipment;

// Set shipper
$shipper = $shipment->getShipper();
$shipper->setShipperNumber('XX');
$shipper->setName('XX');
$shipper->setAttentionName('XX');
$shipperAddress = $shipper->getAddress();
$shipperAddress->setAddressLine1('XX');
$shipperAddress->setPostalCode('XX');
$shipperAddress->setCity('XX');
$shipperAddress->setStateProvinceCode('XX'); // required in US
$shipperAddress->setCountryCode('XX');
$shipper->setAddress($shipperAddress);
$shipper->setEmailAddress('XX'); 
$shipper->setPhoneNumber('XX');
$shipment->setShipper($shipper);

// To address
$address = new \Ups\Entity\Address();
$address->setAddressLine1('XX');
$address->setPostalCode('XX');
$address->setCity('XX');
$address->setStateProvinceCode('XX');  // Required in US
$address->setCountryCode('XX');
$shipTo = new \Ups\Entity\ShipTo();
$shipTo->setAddress($address);
$shipTo->setCompanyName('XX');
$shipTo->setAttentionName('XX');
$shipTo->setEmailAddress('XX'); 
$shipTo->setPhoneNumber('XX');
$shipment->setShipTo($shipTo);

// From address
$address = new \Ups\Entity\Address();
$address->setAddressLine1('XX');
$address->setPostalCode('XX');
$address->setCity('XX');
$address->setStateProvinceCode('XX');  
$address->setCountryCode('XX');
$shipFrom = new \Ups\Entity\ShipFrom();
$shipFrom->setAddress($address);
$shipFrom->setName('XX');
$shipFrom->setAttentionName($shipFrom->getName());
$shipFrom->setCompanyName($shipFrom->getName());
$shipFrom->setEmailAddress('XX');
$shipFrom->setPhoneNumber('XX');
$shipment->setShipFrom($shipFrom);

// Sold to
$address = new \Ups\Entity\Address();
$address->setAddressLine1('XX');
$address->setPostalCode('XX');
$address->setCity('XX');
$address->setCountryCode('XX');
$address->setStateProvinceCode('XX');
$soldTo = new \Ups\Entity\SoldTo;
$soldTo->setAddress($address);
$soldTo->setAttentionName('XX');
$soldTo->setCompanyName($soldTo->getAttentionName());
$soldTo->setEmailAddress('XX');
$soldTo->setPhoneNumber('XX');
$shipment->setSoldTo($soldTo);

// Set service
$service = new \Ups\Entity\Service;
$service->setCode(\Ups\Entity\Service::S_STANDARD);
$service->setDescription($service->getName());
$shipment->setService($service);

// Mark as a return (if return)
if ($return) {
    $returnService = new \Ups\Entity\ReturnService;
    $returnService->setCode(\Ups\Entity\ReturnService::PRINT_RETURN_LABEL_PRL);
    $shipment->setReturnService($returnService);
}

// Set description
$shipment->setDescription('XX');

// Add Package
$package = new \Ups\Entity\Package();
$package->getPackagingType()->setCode(\Ups\Entity\PackagingType::PT_PACKAGE);
$package->getPackageWeight()->setWeight(10);
$unit = new \Ups\Entity\UnitOfMeasurement;
$unit->setCode(\Ups\Entity\UnitOfMeasurement::UOM_KGS);
$package->getPackageWeight()->setUnitOfMeasurement($unit);

// Set Package Service Options
$packageServiceOptions = new \Ups\Entity\PackageServiceOptions();
$packageServiceOptions->setShipperReleaseIndicator(true);
$package->setPackageServiceOptions($packageServiceOptions);

// Set dimensions
$dimensions = new \Ups\Entity\Dimensions();
$dimensions->setHeight(50);
$dimensions->setWidth(50);
$dimensions->setLength(50);
$unit = new \Ups\Entity\UnitOfMeasurement;
$unit->setCode(\Ups\Entity\UnitOfMeasurement::UOM_CM);
$dimensions->setUnitOfMeasurement($unit);
$package->setDimensions($dimensions);

// Add descriptions because it is a package
$package->setDescription('XX');

// Add this package
$shipment->addPackage($package);

// Set Reference Number
$referenceNumber = new \Ups\Entity\ReferenceNumber;
if ($return) {
    $referenceNumber->setCode(\Ups\Entity\ReferenceNumber::CODE_RETURN_AUTHORIZATION_NUMBER);
    $referenceNumber->setValue($return_id);
} else {
    $referenceNumber->setCode(\Ups\Entity\ReferenceNumber::CODE_INVOICE_NUMBER);
    $referenceNumber->setValue($order_id);
}
$shipment->setReferenceNumber($referenceNumber);

// Set payment information
$shipment->setPaymentInformation(new \Ups\Entity\PaymentInformation('prepaid', (object)array('AccountNumber' => 'XX')));

Eze (Won't ask for payment) Cheezy, [5/26/2022 7:54 AM]
// Ask for negotiated rates (optional)
$rateInformation = new \Ups\Entity\RateInformation;
$rateInformation->setNegotiatedRatesIndicator(1);
$shipment->setRateInformation($rateInformation);

// Get shipment info
try {
    $api = new Ups\Shipping($accessKey, $userId, $password); 

    $confirm = $api->confirm(\Ups\Shipping::REQ_VALIDATE, $shipment);
    var_dump($confirm); // Confirm holds the digest you need to accept the result
    
    if ($confirm) {
        $accept = $api->accept($confirm->ShipmentDigest);
        var_dump($accept); // Accept holds the label and additional information
    }
} catch (\Exception $e) {
    var_dump($e);
}
