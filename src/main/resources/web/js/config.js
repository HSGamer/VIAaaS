// See https://docs.microsoft.com/en-us/azure/active-directory/develop/scenario-spa-app-registration
// You'll need to add the page as a Redirect URL to Azure as a Single Page Application

// Azure Client ID
const azureClientId = "a370fff9-7648-4dbf-b96e-2b4f8d539ac2";
// Origins that we'll not use https://viaversion.github.io/VIAaaS/ as redirect URL
const whitelistedOrigin = [
    "https://via.re.yt.nom.br"
];
