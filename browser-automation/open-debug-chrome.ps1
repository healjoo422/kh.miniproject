$chromePath = 'C:\Program Files\Google\Chrome\Application\chrome.exe'
$userDataDir = Join-Path $env:LOCALAPPDATA 'Google\Chrome\User Data'

if (-not (Test-Path $chromePath)) {
    Write-Error "Chrome executable not found: $chromePath"
    exit 1
}

$chromeProcesses = Get-Process chrome -ErrorAction SilentlyContinue
if ($chromeProcesses) {
    Write-Host 'Chrome is already running.'
    Write-Host 'To expose your current tabs, exit Chrome completely first, then run this command again.'
    exit 1
}

Start-Process -FilePath $chromePath -ArgumentList @(
    '--remote-debugging-port=9222',
    "--user-data-dir=$userDataDir"
)

Write-Host 'Chrome started with remote debugging on port 9222.'
Write-Host 'After Chrome opens, run: npm run count:tabs'